package com.senbiifx.canvasfxsamples.octopus

import com.senbiifx.canvasfx.core.*


val octopusSketch = sketch {
    val drawOcean = ocean(width, height)
    val drawOctopus = octopus(2.0)
    val locationGenerator = octopusLocationGenerator(100.0, 100.0)
    draw {
        fill = Color.hsb(195.0, 0.2, 1.0)
        fillRect(0.0, 0.0, width, height)
        drawOcean.invoke(this)

        matrix {
            val location = locationGenerator.invoke()
            translate(width * .6 + location.x, height * .5 + location.y)
            drawOctopus.invoke(this)
        }
    }
}

fun ocean(width: Double, height: Double): SketchFunction =
    ocean(width, height, 0.001, 500.0,  Color.hsb(195.0, 1.00, 1.0))

fun ocean(width: Double, height: Double, noiseFactor: Double, startingT: Double, color: Color): SketchFunction {
    var tz = 0.0

    return {
        stroke = color
        val baseY = height - (height * 0.75)
        for(x in 0..width.toInt()){
            val ty = startingT + x * noiseFactor
            val ny = map(noise(ty, tz), 0.0, 1.0, -50.0, 50.0)
            val y = baseY + ny
            strokeLine(x.toDouble(), y, x.toDouble(), height)
        }

        tz += 0.01
    }

}


fun octopus(size: Double): SketchFunction{
    val tentacle1 = tentacle(100.0, 16.0)
    val tentacle2 = tentacle(100.0, 16.0)
    val tentacle3 = tentacle(100.0, 16.0)
    val tentacle4 = tentacle(100.0, 16.0)
    val tentacle5 = tentacle(100.0, 16.0)
    val tentacle6 = tentacle(100.0, 16.0)
    val tentacle7 = tentacle(100.0, 16.0)
    val tentacle8 = tentacle(100.0, 16.0)

    return {
        matrix {
            scale(size, size)
            fill = Color.hsb(358.0, .25, 1.0)
            matrix {
                translate(25.0, 80.0)
                rotate(9.0)
                tentacle5.invoke(this)
            }

            matrix {
                translate(35.0, 80.0)
                rotate(7.0)
                tentacle6.invoke(this)
            }

            matrix {
                translate(45.0, 80.0)
                rotate(5.0)
                tentacle7.invoke(this)
            }

            matrix {
                translate(45.0, 80.0)
                rotate(-1.0)
                tentacle8.invoke(this)
            }


            fill = Color.hsb(358.0, .5, 1.0)
            fillOval(0.0, 0.0,  80.0, 90.0)

            fill = Color.WHITE
            fillOval(20.0, 40.0, 15.0, 23.0)
            fill = Color.BLACK
            fillOval(28.0, 45.0, 5.0, 10.0)


            fill = Color.WHITE
            fillOval(40.0, 40.0, 15.0, 23.0)
            fill = Color.BLACK
            fillOval(44.0, 45.0, 5.0, 10.0)


            fill = Color.hsb(358.0, .5, 1.0)
            matrix {
                translate(16.0, 80.0)
                rotate(15.0)
                tentacle1.invoke(this)
            }

            matrix {
                translate(30.0, 80.0)
                rotate(8.0)
                tentacle2.invoke(this)
            }

            matrix {
                fill = Color.hsb(358.0, .5, 1.0)
                translate(40.0, 80.0)
                rotate(6.0)
                tentacle3.invoke(this)
            }

            matrix {
                fill = Color.hsb(358.0, .5, 1.0)
                translate(55.0, 80.0)
                rotate(-5.0)
                tentacle4.invoke(this)
            }
        }


    }
}


fun tentacle(length: Double, maxSize: Double) : SketchFunction {
    var t = random(1000).toDouble()
    return {
        var xOff = 0.0
        var xOffIncrement = 0.03
        var x = 0.0
        for(y in 0..length.toInt()){
            val size = map(y.toDouble(), 0.0, length, maxSize, 1.0)
            val variation = map(y.toDouble(), 0.0, length, 1.0, 2.0)
            val displacement = map(noise(xOff, t), 0.0, 1.0, -variation, variation)
            x += displacement
            fillOval(x - size / 2, y.toDouble() - size / 2, size, size)
            xOff += xOffIncrement
        }
        t+= 0.008
    }
}


fun octopusLocationGenerator(w: Double, h: Double): () -> Vector{
    var tx = random(100).toDouble()
    var ty = random(100).toDouble()

    return  {
        var nx = noise(tx)
        var x = map(nx, 0.0, 1.0, 0.0, w)
        tx+=0.003

        var ny = noise(ty)
        var y = map(ny, 0.0, 1.0, 0.0, h)
        ty += 0.003
        Vector(x, y)
    }
}