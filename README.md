# HackVision: The ShelterAlter App by UnitedNewbies


### Coding description and demonstration walkthrough

After building the Android mobile application files in the Android Studio IDE we perform this demo on the Pixel 4 in-built emulator. 

The splash screen automatically appears and has a fading animation to navigate to the landing screen which is the login. We enter the shelter manager or co-ordinator’s credentials (which will be pre-assigned by the supervisor). After the id, username and password are verified from our online/cloud database- the firebase real-time database by Google developers- we reach the check-in screen. Here we select from the drop-down menu the guest’s name and their picture appears. We then view the safety check list, deleting the expired or irrelevant ones alongside the guest’s profile details. From here one can enter a new emergency contact or even schedule a new safety check alert.
The app is programming in Kotlin and its resource assets include layout files to strings, colors, styles, dimensions, drawable icons and media. Kotlin good practices are followed like the MVC software design pattern, concurrency and recycler view to improve performance (validated by Profiler recordings) and sound UI/UX principles like colour button affordances and visibility of system status by the progress bar and popup message after the login is successful. Dependencies for the firebase remote database storage, UI widgets and live data using android lifecycles and viewmodels are implemented in the gradle and network use and smooth navigation from the manifest files. Google material design, styles, icons and documentation has been diligently followed as well.


Note: Only reference utilized and relied upon was the Google Developers documentation on Kotlin and Firebase. 

potential extensions are commented out as they require polish, structure and testing before building for the emulator demonstration.

Overall innovative solution pertinent to the Hackathon theme is explained in great-depth in our team's pitch video submission and there is also a Figma clickable high-fidelity prototype as a feature of use case, user stories and target audience research and advent for usability testing and foundation for android development. The link is here: https://www.figma.com/proto/QfL6qk9ioTFNgW2qxp6S3w/App-Mockup?node-id=25%3A100&scaling=min-zoom&page-id=24%3A2&starting-point-node-id=25%3A100&show-proto-sidebar=1 
