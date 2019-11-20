package com.example.quill.models

import com.example.quill.connection.MysqlComponent

case class Asset(asset_id: Int, name: String, asset_value: Option[Double], employee_id: Int, manufacturer_id: Int)

trait AssetModel extends MysqlComponent{

  import ctx._

  val assetTable = quote {
    querySchema[Asset]("Asset"
//
    )
  }

}
