
TDD Tetris Tutorial
===================

In this tutorial you will be implementing a Tetris game using [Test-Driven Development](http://en.wikipedia.org/wiki/Test-driven_development) (TDD). Some 30 of the first tests have been provided, so that you just need to write code to pass them. The purpose of working with these pre-written test cases is to get accustomed to the TDD cycle, and to get some ideas on what kind of tests to write. After doing that for some while, it will be easier when it's time to begin writing your own tests towards the end of this tutorial.

For information about Test-Driven Development, here are some links. It is recommendable to read them before doing this tutorial, so that you would know what TDD is about.

General information about TDD:

- <http://www.butunclebob.com/ArticleS.UncleBob.TheThreeRulesOfTdd>
- <http://www.butunclebob.com/ArticleS.UncleBob.TheBowlingGameKata>
- <http://jamesshore.com/Agile-Book/test_driven_development.html>
- <http://www.agiledata.org/essays/tdd.html>

TDD is more about specifying behaviour than about testing:

- <http://dannorth.net/introducing-bdd>
- <http://blog.daveastels.com/files/BDD_Intro.pdf>
- <http://blog.orfjackal.net/2010/02/three-styles-of-naming-tests.html>

Summary:

- <http://agileinaflash.blogspot.com/2009/03/unclebobs-three-rules-of-tdd.html>
- <http://agileinaflash.blogspot.com/2009/02/red-green-refactor.html>
- <http://agileinaflash.blogspot.com/2009/02/first.html>

This tutorial has been used in the [TDD programming technique and designing code](http://www.cs.helsinki.fi/u/luontola/tdd-2009/) course in the University of Helsinki. The [lecture slides](http://www.cs.helsinki.fi/u/luontola/tdd-2009/luennot) and [exercises](http://www.cs.helsinki.fi/u/luontola/tdd-2009/harjoitukset) of that course can also be helpful (the material is in English, but for the rest of the site you can use [Google Translate](http://translate.google.com/)).


The Steps of the Tutorial
-------------------------

Use the tests in the [src/test/java/tetris](http://github.com/orfjackal/tdd-tetris-tutorial/tree/tutorial/src/test/java/tetris/) directory to write a Tetris game. Implement code to pass the tests, one file and one test at a time, in the same order as they are listed below, starting with `FallingBlocksTest`.

When you first run the tests, you should see the first test (`A_new_board.is_empty`) failing. Fix the code (a one-line change) and run the tests to see it pass. Then uncomment the following test (`A_new_board.has_no_falling_blocks`). When that test passes, uncomment the next one (`When_a_block_is_dropped.the_block_is_falling`) and make it pass, until finally you have written code which passes all tests in that class. Then open the next test class and keep on continuing in the same fashion.

Reference implementations for the steps of this tutorial have been [tagged in its Git repository](https://github.com/orfjackal/tdd-tetris-tutorial/tags?after=take2%2Fpomodoro1). There are also [Let's Code screencasts](http://www.orfjackal.net/lets-code#tdd-tetris-tutorial) of implementing the [take3 branch](https://github.com/orfjackal/tdd-tetris-tutorial/tree/take3). Also the [beyond](https://github.com/orfjackal/tdd-tetris-tutorial/tree/beyond) and [take2](https://github.com/orfjackal/tdd-tetris-tutorial/tree/take2) branches have reference implementations. It might be helpful to have a look at them *after* you have yourself implemented this tutorial that far or you get stuck with your design.

1. **FallingBlocksTest**

    In Tetris, the most important feature is that there are blocks which fall down, so that is the first behaviour which we will specify by writing tests. It is good to start the writing of a program with a very trivial test. In this case, we will first make sure that we have an empty game board.

    We'll use the [Simplification strategy](http://www.infoq.com/presentations/responsive-design) and first deal with just falling 1x1 blocks. We can expand that later to handle more complex multi-block pieces. It's best to avoid taking too big steps.

    *Design Hint:* In line with YAGNI, avoid introducing new classes or patterns until there is a [demonstrated need](http://www.jbrains.ca/permalink/the-four-elements-of-simple-design) for them. For example, don't introduce class when just a `char` is enough. Don't introduce a two-dimensional array when just a scalar field is enough. Later when the real need for them arises, you will have learned more about the code's needs and you'll be able to make a better design without having to undo your old designs.  

2. **RotatingPiecesOfBlocksTest**

    Rotating the pieces in Tetris is also very important, so let's code that next. You might need pen and paper when figuring out how the shape coordinates change when the shape is rotated.

    I decided to go for a generic algorithm for rotating any shapes. Another option would have been to hard-code the rotations of each shape. Both have their pros and cons. But even if this decision would prove to be bad when the game evolves furher, good test coverage and decoupled code will make it possible to change it afterwards.

3. **RotatingTetrominoesTest**

    [Tetrominoes](http://en.wikipedia.org/wiki/Tetromino) can have 1, 2 or 4 different orientations when they are rotated. Now we can take advantage of the shape rotation code which we wrote just a moment ago.

    Notice that the first test specifies the `Tetromino` objects to be immutable. Check the Wikipedia article about [immutable objects](http://en.wikipedia.org/wiki/Immutable_object) if that concept is new to you. Defaulting to immutability is a good thing.

    Also notice that the I shape has only two possible orientations and the O shape has only one orientation. The tests are the way they are by design. Did you know that Tetris has many alternative [rotation systems](http://tetris.wikia.com/wiki/Category:Rotation_Systems)? 

    *Design Hint:* If you are thinking of making the `Tetromino` class extend the `Piece` class, first read about the [Liskov Substitution Principle](http://butunclebob.com/ArticleS.UncleBob.PrinciplesOfOod) to know when it's right for a class to inherit another. In general, it's best to [favor composition over inheritance](http://www.artima.com/lejava/articles/designprinciples4.html).

4. **FallingPiecesTest**

    Next we will connect the falling blocks and the rotatable pieces. In order to make the first test pass, you will probably need to refactor your code quite much (for me it took 1½ hours). You will need to build suitable abstractions, so that single-block pieces and multi-block pieces can be handled the same way (changing the test code should not be necessary). When refactoring, you must keep the tests passing between every small change, or you will end up in [refactoring hell](http://c2.c2.com/cgi/wiki?RefactoringHell). If more than five minutes have passed since the last time all tests passed, it's best to revert your code from source control to the last version where all tests passed.

    The difficulty of this refactoring depends on how well factored the code is. You could even say that the difficulty of this refactoring is inversely proportional to the length of the `Board.tick()` method (if most of the logic is in that one method, instead of using [Composed Method](http://www.infoq.com/presentations/10-Ways-to-Better-Code-Neal-Ford), then you're in trouble). If you get stuck, there are refactoring examples in [this PDF presentation](http://www.cs.helsinki.fi/u/luontola/tdd-2009/kalvot/04.1-Refactoring-Example.pdf) and [this YouTube video](https://www.youtube.com/watch?v=nU3-sCxQMq0).

5. **MovingAFallingPieceTest**

    Now it's your turn to write the tests. I've provided some TODO items which should hint you on what tests to write.

    Feel free to refactor the test code and change any of the previosly used class or method names to be more descriptive, because there are no more predefined tests which might become incompatible with your code. Both production code and test code need to be taken care of, so you should regularly see if there is something to improve and then refactor it.

6. **RotatingAFallingPieceTest**

    Keep on writing your own tests. You're getting the hang of it!

7. **And beyond...**

    Next you should implement the following features in suitable order: removing full rows, counting removed rows, counting score, game over, choosing the next piece by random (using a [shuffle bag](http://kaioa.com/node/53)). For counting the removed rows, you could launch an event (call a listener's method) when a row is removed - [Mockito](http://mockito.org/) might come in handly for testing that.

    Also change the game to use the [rotation rules of TGM](http://bsixcentdouze.free.fr/tc/tgm-en/tgm.html#rotations). In order to do that, it would be good to replace the earlier generic algorithmic shape rotation (which was done in step 2) with one where each orientation of a shape is hardcoded, because that will probably simplify the code considerably. When you have made the change, evaluate that which of the implementations is better, and remove all code that relates to the worse implementation - [deleting code](http://objectmentor.com/resources/articles/craftsman4.pdf) is a good thing.

    Soon after that you should be able to create a user interface which is only a thin wrapper over the already implemented functionality. Automated testing of user interfaces is generally hard to do, but by separating the UI model from its view it is possible, by minimizing the code which is not tested automatically (see [these articles](http://martinfowler.com/eaaDev/ModelViewPresenter.html)).


### What Next? ###

After you have completed this tutorial, you should have a rough understanding of how to use TDD - you should be at the [Practicing](http://www.agileskillsproject.com/skill-levels)/[Shu](http://martinfowler.com/bliki/ShuHaRi.html)/[Advanced Beginner](http://en.wikipedia.org/wiki/Dreyfus_model_of_skill_acquisition) level. You will probably still struggle with things like always writing a test first, using small enough steps, writing self-documenting tests, keeping the code clean etc. Also most of the tests in this tutorial are perhaps confusingly similar (they verify all game state using `toString()`) so you should practice writing tests for different kinds of situations. Likewise, this tutorial uses a bottom-up approach to TDD, which has the risk of producing something that is not needed, so learning also [a top-down approach](http://blog.orfjackal.net/2010/07/design-for-integrability.html) would be beneficial.

You should continue practicing by writing lots of small applications using TDD, until TDD becomes second nature to you and you can use it ["when you have to get it done"](http://www.vimeo.com/groups/7657/videos/3756344). Learning that will take many months. It's also recommendable to read the books [Clean Code: A Handbook of Agile Software Craftsmanship](http://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882) and [Growing Object-Oriented Software, Guided by Tests](http://www.amazon.com/Growing-Object-Oriented-Software-Guided-Tests/dp/0321503627). The former book teaches how to write good code. The latter book teaches how to use TDD to drive the design.


License
-------

Copyright © 2008-2015 Esko Luontola <<http://www.orfjackal.net>>  
You may use and modify this material freely for personal non-commercial use.  
This material may NOT be used as course material without prior written agreement.
