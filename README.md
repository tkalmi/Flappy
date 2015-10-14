# Flappy

First commit: get a blank window running
Implemented input class: Space button down inputs "FLAP" to console
Implemented math: Removed Space button down "FLAP" thingie, and implemented Vector3f and Matrix4f (+ BufferUtils) classes
Implemented shader: Implemented ShaderUtils and Shader
Implemented texture: Implemented Texture class
Implemented vertex array: Implemented VertexArray class + minor fix to Shader class -> onto making the actual game!
Implemented level: Implemented Level (also into Main) + minor fixes to Shader, ShaderUtils and FileUtils
Background renderable: Background image is visible when running the code
Background scrolls some: Background scrolls (though not completely right)
Background scroll fix 1: Makes scroll continuous
Implemented bird with movement: Bird moves smoothly in 2D
Implemented flappiness: Bird jumps up when space is pressed, otherwise falls down.
Removed white box from bird: No more whites around bird
Added tilting to bird: Bird is tilted towards where it is headed
Implemented pipes: Now there are pipes on the level
Pipes fix 1: Top pipes are now rotated
Bird fix 1: Bird now in front of pipes
Implemented pipe loop: Pipes are now looping
Implemented collision and fade: Bird now dies if it collides with pipes + fading
