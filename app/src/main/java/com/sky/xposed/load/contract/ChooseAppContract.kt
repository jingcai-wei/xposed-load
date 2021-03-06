/*
 * Copyright (c) 2018 The sky Authors.
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

package com.sky.xposed.load.contract

import com.sky.android.core.interfaces.IBasePresenter
import com.sky.android.core.interfaces.IBaseView
import com.sky.xposed.load.data.model.AppModel

/**
 * Created by sky on 18-1-7.
 */
interface ChooseAppContract {

    interface View : IBaseView {

        fun onLoadApps(models: List<AppModel>)

        fun onLoadAppsFailed(msg: String)

        fun onSearchApp(models: List<AppModel>)

        fun onSearchAppFailed(msg: String)
    }

    interface Presenter : IBasePresenter {

        fun setFilter(filter: Int)

        fun getFilter(): Int

        fun loadApps()

        fun searchApp(keyword: String)
    }
}