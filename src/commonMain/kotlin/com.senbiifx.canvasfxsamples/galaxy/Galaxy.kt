package com.senbiifx.canvasfxsamples.galaxy

import com.senbiifx.canvasfx.core.*
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.sin

val galaxy = sketch {
    val maxRadius = lazy { max(width, height) / 2 + 50 }

    setup {

    }

    setup {

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

                radius += 0.05
                angle += 0.1
            }



            radius = 0.0
            angle = 180.0
            while(radius < maxRadius.value){
                val x = sin(angle.toRadians()) * radius
                val y = cos(angle.toRadians()) * radius

                fillOval(x, y, 15.0, 15.0)

                radius += 0.05
                angle += 0.1
            }
        }

    }
}

