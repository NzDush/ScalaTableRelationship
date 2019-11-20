package com.example.quill.components

import com.example.quill.models.{Asset, AssetModel, Manufacturer, ManufacturerModel}
import com.example.quill.connection.MysqlComponent
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object AssetComponent extends MysqlComponent
                              with AssetModel
                              with ManufacturerModel
                              with IOComponent
{

  import ctx._

  def findById(assetId: Int): Future[List[Asset]] = {
    val filterAssetsById = quote{
      assetTable
        .filter(_.asset_id == lift(assetId))
    }
//    val str = ctx.translate(filterAssetsById)
//    println(str)

    val result = ctx.run(filterAssetsById)
    result
  }

  def findByIdWithTableMapping(assetId: Int): Future[List[Manufacturer]] = {
    val filterAssetsById = quote{
      assetTable
        .filter(_.asset_id == lift(assetId))
        .flatMap(ast => manufacturerTable
          .filter(mfr => mfr.manufacturer_id == ast.manufacturer_id)
        )
    }
//    val str = ctx.translate(filterAssetsById)
//    println(str)

    val result = ctx.run(filterAssetsById)
    result
  }

}
