# QR-reader-version-1

I have made this project because at that time, I did not know how to use OpenCV remotely on the Raspberry Pi using Java. So what my idea at that time was that I could make a Java script that remotely connects to the Raspberry Pi which is very easy to do with Apache NetBeans 14. So I have saved the script.py locally in the Pi, so that I run the QR reader remotely. 

The python script is based of a guide, with some minor changes. The link is provided below:
https://core-electronics.com.au/guides/raspberry-pi/QR-codes-raspberry-pi/

Reader.java uses the script.py whereas Reader2.java uses the script2.py. The difference between them is that the Reader2 does not output error lines, does not print out repeated data. 

This project was used with another project.

This code can be ran remotely and locally.
You will need a webcam in your PC or an camera in your Raspberry Pi for this to work.
OpenCV needs to be installed for this project to work.
