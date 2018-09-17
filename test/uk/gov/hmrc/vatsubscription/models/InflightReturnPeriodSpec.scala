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

import assets.TestUtil
import play.api.libs.json.Json

class InflightReturnPeriodSpec extends TestUtil {

  "InFlightReturnPeriod Reads" when {

    "calling .readsV3_2_1" should {

      val json = Json.obj(
        "stdReturnPeriod" -> "MA"
      )

      val model: InflightReturnPeriod = MAInflightReturnPeriod

      "output a correctly formatted UpdatedReturnPeriod json" in {
        InflightReturnPeriod.readsV3_2_1.reads(json).get shouldEqual model
      }
    }

    "calling .readsV3_3" should {

      val json = Json.obj(
        "returnPeriod" -> "MA"
      )

      val model: InflightReturnPeriod = MAInflightReturnPeriod

      "output a correctly formatted UpdatedReturnPeriod json" in {
        InflightReturnPeriod.readsV3_3.reads(json).get shouldEqual model
      }
    }
  }
}
