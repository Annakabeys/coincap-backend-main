package models.domain

import play.api.libs.json._
import scala.collection.mutable

case class AssetList (
    name: String,
    priceUsd: String,
    symbol: String,
    rank: String
)

object AssetList {
    val asset = mutable.ListBuffer[AssetList]()
    implicit val writer: Writes[AssetList] = Json.writes[AssetList]
}