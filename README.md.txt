# SpaceCrusaders
Mobile Android Game made as part of COMP2100 Assignment (2018, Australian National University)

# Retro Game - Space Crusaders

## Team structure and roles 
Kriti Tripathi u6058693 - member liaison, note taker, user input such as menus etc., documentation checker, game graphics, scoring implementation, user documentation.

Jasper McNiven u6052551 - team leader, game state, game logic, obstacle generation

Yatindra Tripathi u6387599 - debugger, assests, game graphics rendering, tricky android code, game icon

Septian Razi u6086829 - morale builder, game logic, tricky android code, UML diagram, water boy 

## Game Overview
<img src="/screenshots/game_icon.png" width=30% height=40%>
<img src="/screenshots/main_menu.png" width=30% height=40%>
<img src="/screenshots/options.png" width=30% height=40%>
<img src="/screenshots/instructions.png" width=30% height=40%>
<img src="/screenshots/jump.png" width=30% height=40%>
<img src="/screenshots/game_over.png" width=30% height=40%> 

Assignment 1 Retro Game required an implementation of a user friendly game through the android studio application. The game implemented by our group was Space Crusaders. Running the game application will result in a ‘Main Menu’ screen with four buttons. Each button has an important role. The first button – ‘New Game – simply starts a new game whereas the second button ‘Options’ allows the user to  set preferences such as whether the background music and/or sound effects are on/off; the speed of incoming obstacles; how strong the gravity is, etc . The instructions button on the main menu aids the user in developing their comprehension of how to play the game whilst the remaining ‘Exit’ button allows the user to leave the game. 


As can be seen in the snapshots above, our game draws elements from Flappy Birds – with the aim of the game requiring the player to jump through and avoid obstacles for as long as possible. Notwithstanding, Space Crusaders has some original features ranging from  coin rewards that add extra points to the player score to space influenced theme. Unlike Flappy Birds, Space Crusaders has a user friendly UI that allows easy navigation of the game.


## Design Documentation 

UML Diagram:


<img src ="/screenshots/UML.png">


Design Summary:


The main design approach used to implement this game was Object Oriented Design. This was mainly achieved by having a base class, ‘GameObject’ in our case which every logic/non-activity class extends. For example, we have a ‘Coin’ class which extends the base class and ‘GameObjectList’ class which is merely a list of ‘GameObjects’. This allowed the implementation of the  game to be divided into four main parts as seen in the UML diagram above: game logic, activity, graphics and sound effects/music (represented by yellow, red green and blue respectively). Another example of this approaches being implemented is the way music and sound effects work. This was accomplished by making an abstract class Manager which is extended by both SoundEffectsManager and MusicManager. Evidently, this allowed the code to be more organised and pithy. This also allowed for extensions to be added to the project without any major re-designing due to the object oriented design. For example, the 'Coin' class was added as an after-thought and was implemented very easily by merely extending the 'GameObject' base class. 

This hierarchical class system made it much easier to code, especially when our application started becoming large and more complex. Inspired by the Observer design pattern, in our logic and views we used the GameObjectList as a pseudo-observer, updating the underlying classes (such as Coin, Obstacles and Spaceship) on events occurring in the gameActivity. An example of this is our frequent use of gameObject.update(), which updates all the gameObjects currently instantiated. This eliminated the need to call each individual gameObject’s update function, significantly reducing the difficulty of programming the application.


Testing summary:


To make sure that our android app was functioning as expected testing was carried out on all off the game logic. The game logic included many different functions and classes which were all tested via black box, white box and integration testing. The functional requirements of the code were tested using black box testing and these tests check whether the obstacle and coin generation is working as expected. White box testing was used to test collision of the space ship with obstacles by making some test cases that have a good coverage of the code. Integration tests were used to check the whole game as one unit. This integration test can be found under ‘SampleGameTest’ and it tests all the logic together by simulating a game. 


Along with the above, the code was tested frequently by us through both an emulator and an android phone to check the user interface. So, for example, it was often the case when the game would be played and the spaceship would be collided with the obstacle on purpose to test the functionality of activity that takes over when the game is over. Frequent testing of buttons and their functionality also occurred and was carried out by pressing different, random buttons numerous times to check if the game would crash. Hence, all the parts of the game were testing using various methods, be it black/white box testing, integration testing or manual testing, and this ensured that the game’s functional behaviour was as expected.  


## Minuted Meetings
Meeting minute 1 ( 8th April 2018 17:00 - 18:30 pm Chifley 4.02):

+ Attendance: Kriti, Razi, Yatindra and Jasper
+ Name initially Space invaders 2 – but not appropriate, deciding on a different group name.
+ Septian Razi created the repository named RetroGame2018s1 and added the rest of us as members. 
+ Initial roles for each members:
    1.	Razi – collision 
    2.	Jasper – game graphics 
    3.	Yatindra – assets, sound,  etc. 
    4.	Kriti – UI
+ Initial skeleton and main classes: Object, ObstacleSegment, Character, MainMenuActivity and GameActivity.
+ The progress so far is a basic menu as shown below

<img src="/screenshots/screenshot1.JPG" width=30% height=40%>

Meeting minute 2 ( 21st April 2018 13:00 - 15:00 pm CSIT N110 - Software Engineering Room )

+ Attendance: Kriti, Razi, Yatindra and Jasper
+ Decided to keep the name Space Invaders 2 - as it is a mix of Space Invaders and Flappy Birds
+ Made a basic UML Diagram as shown below. 

![uml_basic](/screenshots/uml_basic.jpg)

+ Worked on the base classes to make some progress on the assignment. 
+ The progress of the assignment so far: made the menu semi-functional with new game button starting a new game and the character/player being able to jump and move around. (Shown below)

![Meeting_2_progress](/screenshots/Meeting_2_progress.mp4)

Minuted Meeting 3 (6th May 2018, 13:00 - 15:00 pm Ian Ross Study Space )

+ Attendance: Kriti, Razi, Jasper and Yatindra
+ Working on assets: locating and preparing images
+ Scalability: scaling for game objects  
+ Collision algorithm 
+ Working on assests
+ The progress of the assignment so far is as shown below:
![Meeting_3_progress](/screenshots/Meeting_3_progress.mp4)

Minuted Meeting 4 (12th May 2018, 15:00 - 18:30 pm Hancock Level 3 Room 3.28 )
+ Attendance: Kriti, Razi, Jasper and Yatindra 
+ Filling out wiki documentation - Kriti 
+ Obstacle generation - Jasper
+ Finding graphics for obstacles 
+ Fixing collision and movements

Minuted Meeting 5 (18th May 2018, 12:00 - 17:00 pm CSIT Room N114)
+ Attendance: Kriti, Jasper, Razi and Yatindra 
+ Fixing and cleaning up the code
+ Making a game icon for the app
+ Testing and user documentation


## Statement of Originality

I, Kriti Tripathi, declare that everything I have submitted in this
assignment is entirely my own work, with exceptions given below.

I, Yatindra Tripathi, declare that everything I have submitted in this
assignment is entirely my own work, with exceptions given below.

I, Septian Razi, declare that everything I have submitted in this
assignment is entirely my own work, with exceptions given below.

I, Jasper McNiven, declare that everything I have submitted in this
assignment is entirely my own work, with exceptions given below.

### Code
The code in styles.xml for a customised theme from StackOverflow and Youtube:

        <style name="AppTheme.CustomTheme" >
        <item name="android:windowIsTranslucent">true</item>
        <item name="android:windowBackground">@android:color/transparent</item>
        <item name="android:windowContentOverlay">@null</item>
        <item name="android:windowNoTitle">true</item>
        <item name="android:windowIsFloating">true</item>
        <item name="android:backgroundDimEnabled">true</item> </style> 

URL: https://stackoverflow.com/questions/2176922/how-do-i-create-a-transparent-activity-on-android
and https://www.youtube.com/watch?v=h7XwVSNFjZU

The scrolling imageView library was imported from: { url "https://jitpack.io" }

### Inspiration

The idea to form the game and some aspects of it - such as obstacles, scrolling screen, etc. were inspired from the well known game Flappy Birds. The idea of coins was taken from games like Mario and Donkey Kong. 

### Assets 

Background Image:

<img src="/screenshots/background_image.jpg" width=30% height=40%>

URL: https://annamae22.deviantart.com/art/Blue-Space-Background-Stock-Vertical-639148707



The character/space ship:

![image](/screenshots/image.png)

URL: https://www.spriters-resource.com/3ds/regularshowmordecaiandrigbyin8bitland/sheet/66171/



The obstacles:

![image](/screenshots/asteroid.png)

URL: http://astroempires.wikia.com/wiki/Asteroid



The coin:

![image](/screenshots/coin.png)

URL: https://scratch.mit.edu/projects/11984691/



Background Music: https://www.bensound.com/



Sound Effects: https://www.zapsplat.com/
