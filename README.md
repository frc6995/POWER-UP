## POWER-UP
This repository is the code for the 2018 robot of the First Robotics Challenge (FRC) team, 6995 NOMAD.

### Requirements for running this code:

Official FRC Java programming documentation: https://wpilib.screenstepslive.com/s/currentCS/m/java

1. This repository is only supported for development on a 64-bit Windows 10 environment.
2. We use Java 8, so developers will need the JDK 8, build u101. http://www.oracle.com/technetwork/java/javase/downloads/java-archive-javase8-2177648.html
Scroll down to "Java SE Development Kit 8u101", accept the license agreement, and download the Windows x64 version at the end of the list.
3. Developers will also need the JRE 8, build u151, which is on the same webpage. Once again, accept the license agreement, and download the Windows x64 version.
4. Coding is done in Eclipse Oxygen. https://www.eclipse.org/downloads/packages/release/Oxygen/3A 
Download the "Eclipse for Java Developers" for 64-bit Windows. It should show up in Downloads as a .zip file named "eclipse-java-oxygen-3a-win32-x86_64" Unzip this file. Open it and you should see another folder named "eclipse". Move this to Program Files.
5. Start Eclipse and when it asks you to select a workspace type "C:\Users\[username]\eclipse-workspace" where "[username]" is your computer account user. 
6. In Eclipse, go to Window -> Preferences -> General -> Workspace -> Check Save automatically before build -> OK. 


7. Installing the FRC software from National Instruments - This needs the team-specific license number (Serial Number) available from the head coach.

8. You will also need the CTRE Phoenix Framework Installer from http://www.ctr-electronics.com/hro.html#product_tabs_technical_resources

9. Download Git for Windows from https://gitforwindows.org 
Instructions for setting up Git for the first time: https://git-scm.com/book/en/v2/Getting-Started-First-Time-Git-Setup


10. Add the WPI plugins to eclipse as follows: 
When Eclipse starts:

Select "Help"
Click "Install new software".
From here you need to add a software update site, the location where the plugins will be downloaded. Push the "Add..." button then fill in the "Add Repository" dialog with:
Name: FRC Plugins
Location: http://first.wpi.edu/FRC/roborio/release/eclipse/
Click "OK".

Click the arrows if necessary to expand the WPILib Robot Development menu.
Select the WPILib Robot Development plugin for your desired language (you can install both if you wish to try programming in both languages)
Click Next, Next on the next page, then click the radio button to accept the license agreement and click Finish
If you receive a Security Warning prompt, click OK to continue.
When prompted, restart Eclipse. After Eclipse restarts and you select your Workspace (if prompted) you will see a dialog that says Installing Java. This details the installation progress of the plugins, wait for the install to complete before proceeding. This dialog should only appear when the plugins are first installed or updated.
