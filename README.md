## POWER-UP
This repository is the code for the 2018 robot of the First Robotics Challenge (FRC) team, 6995 NOMAD.

### Requirements for running this code:

Official FRC Java programming documentation: https://wpilib.screenstepslive.com/s/currentCS/m/java

1. This repository is only supported for development on a 64-bit Windows 10 environment.
2. We use Java 8, so developers will need the JDK 8, build u101. http://www.oracle.com/technetwork/java/javase/downloads/java-archive-javase8-2177648.html
Scroll down to "Java SE Development Kit 8u101", accept the license agreement, and download the Windows x64 version at the end of the list.
3. Developers will also need the JRE 8, build u151, "Java SE Runtime Environment 8u151" which is on the same webpage. Once again, accept the license agreement, and download the Windows x64 version.
4. Coding is done in Eclipse Oxygen. https://www.eclipse.org/downloads/packages/release/Oxygen/3A 
Download the "Eclipse for Java Developers" for 64-bit Windows. It should show up in Downloads as a .zip file named "eclipse-java-oxygen-3a-win32-x86_64" Unzip this file. Open it and you should see another folder named "eclipse". Move this to Program Files.
5. Start Eclipse and when it asks you to select a workspace type "C:\Users\[username]\eclipse-workspace" where "[username]" is your computer account user. 
6. In Eclipse, go to Window -> Preferences -> General -> Workspace -> Check Save automatically before build -> OK. 


7. Installing the FRC software from National Instruments - This needs the team-specific license number (Serial Number) available from the head coach.
         Create a user account on www.ni.com if you don’t already have one.
         Follow the instructions here: https://wpilib.screenstepslive.com/s/currentCS/m/getting_started/l/599670-installing-the-frc-update-suite-all-languages. To extract the FRC Update Suite zip files, you will need the Encryption Key which is pLaY&4%R3aL! . To activate the NI Vision Acquisition Software you will need our 2018 Activation Code which is (please ask Software mentor or check on Samepage under 'Software Instructions/Help'.

8. You will also need the CTRE Phoenix Framework Installer from http://www.ctr-electronics.com/hro.html#product_tabs_technical_resources

9. Download Git for Windows from https://gitforwindows.org. Run the installer, and before clicking the Finish button select the checkbox to Launch the BASH shell, then click the Finsh button. When the BASH shell window appears type the following:
'''cd ~

mkdir Git

cd Git


git clone http://github.com/frc6995/POWER-UP

'''
This should create ~/Git/POWER-UP/, which contains the latest master version of the FRC 6995 POWER-UP source code.

For more detailed instructions for setting up Git for the first time see https://git-scm.com/book/en/v2/Getting-Started-First-Time-Git-Setup.


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

11. After the plugins are installed, go to Eclipse ->Window ->Preferences-> (you might need to scroll down) Team->WPILib Preferences and set the team number to 6995. (dont forget to apply and close)
