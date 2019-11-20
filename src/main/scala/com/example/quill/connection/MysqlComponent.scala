package com.example.quill.connection

import io.getquill.{MysqlAsyncContext, SnakeCase}

trait MysqlComponent {

  lazy val ctx = new MysqlAsyncContext(SnakeCase, "ctx")

}
