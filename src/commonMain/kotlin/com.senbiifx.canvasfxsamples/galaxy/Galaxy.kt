package com.senbiifx.canvasfxsamples.galaxy

import com.senbiifx.canvasfx.core.*
import kotlin.jvm.Synchronized
import kotlin.math.*
import kotlin.random.Random

val galaxy = sketch {
    val maxRadius = lazy { max(width, height) * .2 }


    draw {

        fill = Color.WHITE

        fillRect(0.0, 0.0, width, height)

        matrix {
            translate(width / 2, height / 2)

            var radius = 0.0
            var angle = 0.0

            fill = Color.ORANGE

            while(radius < maxRadius.value){
                val x = sin(angle.toRadians()) * radius
                val y = cos(angle.toRadians()) * radius
                fillOval(x, y, 15.0, 15.0)


                val x2 = sin(angle.plus(180).toRadians()) * radius
                val y2 = cos(angle.plus(180).toRadians()) * radius
                fillOval(x2, y2, 15.0, 15.0)

                radius += 0.05
                angle += 0.1
            }


        }


    }


}

