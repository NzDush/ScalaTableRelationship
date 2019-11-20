package com.example.quill.main

import com.example.quill.components.AssetComponent
import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App{

  val result1 = AssetComponent.findById(3)
  result1.onComplete{
    case result1 =>  println(result1.get.head)
  }

//  val result2 = AssetComponent.findByIdWithTableMapping(3)
//  result2.onComplete{
//    case result2 =>  println(result2.get.head)
//  }

  System.in.read()

}
