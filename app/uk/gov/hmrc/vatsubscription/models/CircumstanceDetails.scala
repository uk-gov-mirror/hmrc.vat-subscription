/*
 * Copyright 2018 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.vatsubscription.models

import play.api.libs.functional.syntax._
import play.api.libs.json.{JsPath, Writes}


case class CircumstanceDetails(businessName:Option[String],
                               flatRateScheme: Option[FlatRateScheme],
                               ppob: Option[PPOB],
                               bankDetails:Option[BankDetails],
                               returnPeriod: Option[ReturnPeriod])

object CircumstanceDetails {

  private val flatRateSchemeKey = "flatRateScheme"
  private val ppobKey = "PPOB"
  private val bankDetailsKey = "bankDetails"
  private val returnPeriodKey = "returnPeriod"
  private val organisationNamePath = JsPath \ "organisationName"
  private val flatRateSchemePath = JsPath \ flatRateSchemeKey
  private val ppobPath = JsPath \ ppobKey
  private val bankDetailsPath = JsPath \ bankDetailsKey
  private val returnPeriodPath = JsPath \ returnPeriodKey

  implicit val circsWriter: Writes[CircumstanceDetails] = (
      organisationNamePath.writeNullable[String] and
      flatRateSchemePath.writeNullable[FlatRateScheme] and
      ppobPath.writeNullable[PPOB] and
      bankDetailsPath.writeNullable[BankDetails] and
      returnPeriodPath.writeNullable[ReturnPeriod]
    )(unlift(CircumstanceDetails.unapply))

}
