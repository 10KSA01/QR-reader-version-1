
#most importantly for this code to run is to import OpenCV
import cv2
import sys
import os
import time

workingDirectory=os.getcwd()

# set up camera object called Cap which we will use to find OpenCV
cap = cv2.VideoCapture(0)

# QR code detection Method
detector = cv2.QRCodeDetector()

# List of things it read
listQR = []

#os.environ['DISPLAY'] = ':0'

t_end = time.time() + int(sys.argv[1])
#This creates an Infinite loop to keep your camera searching for data at all times
while time.time() < t_end:
    # Below is the method to get a image of the QR code
    _, img = cap.read()
    
    # Below is the method to read the QR code by detetecting the bounding box coords and decoding the hidden QR data 
    data, bbox, _ = detector.detectAndDecode(img)
    
    if (bbox is not None):
        bb_pts = bbox.astype(int).reshape(-1, 2)
        num_bb_pts = len(bb_pts)
        for i in range(num_bb_pts):
            cv2.line(img,
                     tuple(bb_pts[i]),
                     tuple(bb_pts[(i+1) % num_bb_pts]),
                     color=(255, 0, 255), thickness=2)
        cv2.putText(img, data,
                    (bb_pts[0][0], bb_pts[0][1] - 10),
                    cv2.FONT_HERSHEY_SIMPLEX,
                    0.5, (0, 255, 0), 2)
        
        #Below prints the found data to the below terminal (This we can easily expand on to capture the data to an Excel Sheet)
        #You can also add content to before the pass. Say the system reads red it'll activate a Red LED and the same for Green.
        
        # Version 2 - Only stores data found once. Dupplicated data will not be added in list
        if data:
            if data not in listQR:
                listQR.append(data)
                print(data)

                    
    # Below will display the live camera feed to the Desktop on Raspberry Pi OS preview
    cv2.imshow("code detector", img)
    #At any point if you want to stop the Code all you need to do is press 'q' on your keyboard
    if(cv2.waitKey(1) == ord("q")):
        break
    if cv2.getWindowProperty("code detector", cv2.WND_PROP_VISIBLE) <1:
        break

# When the code is stopped the below closes all the applications/windows that the above has created
cap.release()
cv2.destroyAllWindows()

print(listQR)
