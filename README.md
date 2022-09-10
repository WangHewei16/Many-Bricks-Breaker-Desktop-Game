## Many-Bricks-Breaker-Desktop-Game

#### 1. Overall Introduction
* Implemented game interface directories, including “Play Game”, “High Scores”, “Get Help”, and “Exit”. Players can view the names and scores of the top 10 players in “High Scores”.
* Achieved functions:
  + When the ball hits the racket, walls, and bricks, there will be a physics-based rebound. As for the ball hitting the board edge, a trigonometric function changes the random exit angle r (10<r<30). 
  + Reward mechanism:
    *  `Multiple balls`: each ball is divided into three, moving at slightly different angles.
    *  `Wide paddle`: The board’s width can be doubled to the original length in a period.
    *  `Sticky racket`: When the ball hits the racket, the ball does not bounce but sticks to the racket. Players can double-tap the screen to restart.
    *  `Laser cannon`: The board can emit lasers and destroy a row of bricks directly above the board.
  + Level: Level 5 can be achieved in code. I named them according to the shape combination of the bricks.
  + Highest score and leaderboard mechanism: I use a file to load and save the previous highest score. When the score exceeds the last highest score, the new highest score will be kept in the file and displayed at the top of the screen. At the same time, the top 10 high scores can be displayed in the “High scores” list in the catalog.

#### 2. Technologies

`Platform:` desktop <br>
`Programming language:`
* Front end: Java Swing
* Back end: Java


#### 3. Game Display
