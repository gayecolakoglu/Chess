# Chess

In this project I implemented a command line chess program (a simpler version).

## Class Diagram

![image](https://user-images.githubusercontent.com/55553433/152215678-10c6dcb3-5805-4a7f-a9f4-c4c541bf0ccc.png)

The class diagram above shows the classes and their relations. ChessBoard class represents board in a chess game. A chessboard object contains 64 Square objects each having attributes to hold location information. In addition, a Square object may contain a Piece object. Piece class is super class of King, Queen, Rook, Bishop, Knight and Pawn classes. The diagram shows some important attributes and methods.

## Functionality
I implemented game partially. In my implementation game can be played with following features
  - End game control : you can end the game when no pieces exist from one color.
  - Promote: You can assume at the last row Pawn only becomes a Queen . 
I did not implement the following functionalities:
  - Absolute pin: a piece can be played even it would put the King into check
  - Check control: you can assume Kings can be captured as normal pieces. 
  - En Passant rule: after a Pawn moves two squares from its starting square, and it could have been captured by an enemy Pawn had it advanced only one square.

In summary, we can assume the purpose of the game is to capture opponent’s all pieces, not to check mate

## Board Representation

![image](https://user-images.githubusercontent.com/55553433/152216233-c9a5acb1-c47c-4250-b5f0-5bddf0771979.png)

I draw the board to command line as shown above. 
  - Coordinate information should be given at all sides as real life chess board. 
  - Square borders should be drawn with proper symbols as in the Figure 2
  - Letters are used to represent pieces in Squares.  P for Pawn
    - R for Rook
    - N for Night
    - B for Bishop
    - Q for Queen
    - K for King
- Use Uppercase letters for white pieces, lower case letters for black pieces

## Example Execution

![image](https://user-images.githubusercontent.com/55553433/152217588-9832e0a7-1891-4bdb-8ebc-ad1b0fd091be.png)  ![image](https://user-images.githubusercontent.com/55553433/152217632-bcfe9ff2-1d07-4f51-8a91-ad0580b0f5d8.png)  ![image](https://user-images.githubusercontent.com/55553433/152219215-0f72bf79-8262-4041-9bda-041f52ee3637.png)


In two attempts location of the white piece was not correct. In fact the main logic of the
application is given in Main class which is available in Appendix. You will also find
implementation of Pawn class. You should implement the missing classes to provide requested
functionality. If you need, you can update Main and Pawn classes.
