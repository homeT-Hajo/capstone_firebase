/*
 * Copyright 2019 The TensorFlow Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tensorflow.lite.examples.posenet

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.tensorflow.lite.examples.posenet.Extensions.toast

class CameraActivity : AppCompatActivity() {


  override fun onCreate(savedInstanceState: Bundle?) {

      var test = "데이터 안넘어 와~~~~"
      var intent = getIntent();
      var exercise1 = intent.getStringExtra("exercise1")
      var exercise2 = intent.getStringExtra("exercise2")

      var count = intent.getStringExtra("count")

      if(exercise1!=null&&count!=null){
          Log.d("운동이이이름", exercise1)
          Log.d("개애애애수", count)
      }
      else if(exercise2!=null&&count!=null){
          Log.d("운동이이이름", exercise2)
          Log.d("개애애애수", count)
      }
      else {
          Log.d("뭐",test)
      }
     /* Log.d("운동이이이름", exercise1)
      Log.d("개애애애수", count)*/

    super.onCreate(savedInstanceState)
    if (ClickState =="sidejack 학습"){
      setContentView(R.layout.tfe_pn_activity_camera)
      savedInstanceState ?: supportFragmentManager.beginTransaction()
          .replace(R.id.container, PracticeActivity())
          .commit()

    }
    else if (ClickState == "sidejack 운동"){
      setContentView(R.layout.tfe_pn_activity_camera)
      savedInstanceState ?: supportFragmentManager.beginTransaction()
          .replace(R.id.container, PosenetActivity().apply{
              arguments = Bundle().apply{
                  putString("exercise1",exercise1)
                  putString("count",count)
              }
          })
          .commit()
    }
    else if (ClickState == "sidebend left 학습"){
      setContentView(R.layout.tfe_pn_activity_camera)
      savedInstanceState ?: supportFragmentManager.beginTransaction()
              .replace(R.id.container, PracticeActivity())
              .commit()
    }
    else if (ClickState == "sidebend left 운동"){
      setContentView(R.layout.tfe_pn_activity_camera)
      savedInstanceState ?: supportFragmentManager.beginTransaction()
              .replace(R.id.container, PosenetActivity().apply{
                  arguments = Bundle().apply{
                      putString("exercise1",exercise1)
                      putString("count",count)
                  }
              })
              .commit()
    }
    else if (ClickState =="sidebend right 학습"){
        setContentView(R.layout.tfe_pn_activity_camera)
        savedInstanceState ?: supportFragmentManager.beginTransaction()
            .replace(R.id.container, PracticeActivity())
            .commit()

    }
    else if (ClickState == "sidebend right 운동"){
        setContentView(R.layout.tfe_pn_activity_camera)
        savedInstanceState ?: supportFragmentManager.beginTransaction()
            .replace(R.id.container, PosenetActivity().apply{
                arguments = Bundle().apply{
                    putString("exercise2",exercise2)
                    putString("count",count)

                }
            })
            .commit()
      }
    else if (ClickState == "widesquat 학습"){
        setContentView(R.layout.tfe_pn_activity_camera)
        savedInstanceState ?: supportFragmentManager.beginTransaction()
            .replace(R.id.container, PracticeActivity())
            .commit()
    }
    else if (ClickState == "widesquat 운동"){
        setContentView(R.layout.tfe_pn_activity_camera)
        savedInstanceState ?: supportFragmentManager.beginTransaction()
            .replace(R.id.container, PosenetActivity().apply{
                arguments = Bundle().apply{
                    putString("exercise1",exercise1)
                    putString("count",count)
                }
            })
            .commit()
    }
  }
}