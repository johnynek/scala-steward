/*
 * Copyright 2018-2019 Scala Steward contributors
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

package org.scalasteward.core

import better.files.File
import cats.implicits._

package object io {
  def isSourceFile(file: File): Boolean = {
    val scalaOrSbtFile = file.extension.exists(Set(".scala", ".sbt"))
    val travisYmlFile = file.name === ".travis.yml"
    val sbtPropertiesFile = file.name === "build.properties"
    val notInGitDir = !file.pathAsString.contains(".git/")
    (scalaOrSbtFile || travisYmlFile || sbtPropertiesFile) && notInGitDir
  }
}
