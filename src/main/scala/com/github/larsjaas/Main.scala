package com.github.larsjaas

import zio._
import com.github.larsjaas.BuildInfo

object Main extends zio.App {

    def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] = {
        if (args.headOption.contains("--version")) {
            println(s"${BuildInfo.name} v${BuildInfo.version}")
            return ZIO.succeed(ExitCode.success)
        }

        ZIO.succeed(ExitCode.success)
    }
}