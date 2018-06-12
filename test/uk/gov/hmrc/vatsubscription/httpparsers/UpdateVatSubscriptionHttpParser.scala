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

package uk.gov.hmrc.vatsubscription.httpparsers

import play.api.http.Status
import play.api.libs.json.{JsObject, Json}
import uk.gov.hmrc.http.HttpResponse
import uk.gov.hmrc.play.test.UnitSpec
import uk.gov.hmrc.vatsubscription.httpparsers.UpdateVatSubscriptionHttpParser.UpdateVatSubscriptionReads
import uk.gov.hmrc.vatsubscription.models.updateVatSubscription.response.SuccessModel

class UpdateVatSubscriptionHttpParser extends UnitSpec {

  "UpdateVatSubscriptionReads .read" when {

    "an OK response is returned" when {

      "valid json is returned" should {

        "return a SuccessModel" in {
          val response: JsObject = Json.obj("formBundle" -> "12345")

          val result = UpdateVatSubscriptionReads.read("", "", HttpResponse(Status.OK, Some(response)))

          result shouldBe SuccessModel(formBundle = "12345")
        }
      }

      "invalid json is returned" should {

        "return an ErrorModel" in {

        }
      }
    }

    "a non-OK response is returned" when {

      "valid json is returned" should {

        "return an ErrorModel" in {

        }
      }

      "invalid json is returned" should {

        "return an ErrorModel" in {

        }
      }
    }
  }
}
