package com.example.slick.main

import com.example.slick.components.{AssetComponent, IOComponent}
import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Main extends App with
                    IOComponent {

  val result1 = Await.result(AssetComponent.findById(5), Duration.Inf)
  println(result1.head)

//  val result2 = Await.result(AssetComponent.findByIdWithTableMapping(5), Duration.Inf)
//  println(result2.head)

}
