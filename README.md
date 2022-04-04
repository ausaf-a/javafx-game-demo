# JavaFX Sprite Engine
 ![Gif](./images/overpopulation.gif)

## Motivation
I was building a game using JavaFX for a class, but an issue we ran into was there not being an easy to use animation framework for JavaFX. I didn't see what stopped this from being possible, so I implemented this myself using the JavaFX Scene Graph SDK. All drawing is done using JavaFX nodes without obtaining the underlying graphics context. The advantage of this approach is that it is easy to integrate with a standard JavaFX application compared to a canvas based approach. 

## Approach 
Generally, animation in games is done using spritesheets. The system takes in a spritesheet image, a tile grid size, and builds animations as a sequence of rectangular regions within the sprite sheet image.  
 
