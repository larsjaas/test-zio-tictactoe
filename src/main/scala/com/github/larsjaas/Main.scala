package com.github.larsjaas

import zio.{console, App, ZEnv, ZIO}
import zio.console.Console

import java.io.IOException

object TicTacToe extends zio.App {

    def program: ZIO[Console, Nothing, Unit] =
        console.putStrLn("TicTacToe game!").orDieWith(_ => new Error("Boom"))

    def run(args: List[String]): ZIO[ZEnv, Nothing, Int] = {
        program.foldM(
            error => console.putStrLn(s"Execution failed with: ${error}").orDieWith(_ => new Error("Boom")) *> ZIO.succeed(1),
            _ => ZIO.succeed(0)
        )
    }
}