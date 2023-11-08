package models.domain

import java.util.UUID
import play.api.libs.json._

case class Portfolio (
    id: UUID,
    name: String,
    holdings: String,
    quantity: BigDecimal
)

object Portfolio {
    val tupled = (apply: (UUID, String, String, BigDecimal) => Portfolio).tupled
    def apply (name: String, holdings: String, quantity: BigDecimal): Portfolio = apply(UUID.randomUUID(), name, holdings, quantity)
    implicit val writer: Writes[Portfolio] = Json.writes[Portfolio]
}