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

package com.sky.xposed.load.presenter

import com.sky.xposed.load.contract.PluginManagerContract
import com.sky.xposed.load.data.local.PluginManager
import com.sky.xposed.load.data.model.PluginModel

/**
 * Created by sky on 18-1-5.
 */
class PluginManagerPresenter(
        private val pluginManager: PluginManager,
        private val view: PluginManagerContract.View
) : AbstractPresenter(), PluginManagerContract.Presenter {

    override fun loadPlugins() {

        ioToMain(pluginManager.loadPlugins())
                .subscribe({
                    view.cancelLoading()
                    view.onLoadPlugins(it)
                }, {
                    view.cancelLoading()
                    view.onLoadPluginsFailed(it?.message?:"")
                })
    }

    override fun updatePlugin(model: PluginModel, packageNames: List<String>, status: Int) {

        ioToMain(pluginManager.updatePlugin(model, packageNames, status))
                .subscribe({
                    view.onUpdatePlugin(it)
                }, {
                    view.onUpdatePluginFailed(it?.message?:"")
                })
    }
}