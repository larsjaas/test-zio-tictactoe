package com.github.larsjaas

import zio._
import com.github.larsjaas.BuildInfo

import java.io.IOException

object TicTacToe extends zio.App {

    def program: ZIO[Console, IOException, Unit] =
        Console.putStrLn("TicTacToe game!").orDieWith(_ => new Error("Boom"))

    def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] = {
        program.foldM(
            error => Console.putStrLn(s"Execution failed with: ${error}").orDieWith(_ => new Error("Boom")) *> ZIO.succeed(ExitCode.failure),
            _ => ZIO.succeed(ExitCode.success)
        )
    }
}