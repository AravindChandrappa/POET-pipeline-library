/*
 * Copyright © 2019 T-Mobile USA, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tmobile.sre.pipeline.reader.templates

import java.nio.file.NoSuchFileException

/**
 * Externally defined files.
 *
 * file.yml@repository
 */
class RemoteFilePath implements Serializable {
  String file
  String pathAlias


  /**
   * Returns a RemoteFilePath for a given path string.
   *
   * @throws NoSuchFileException if path does not contain a location
   */
  static RemoteFilePath parse(String path) {
    def parts = path.split("@")

    if (parts.length != 2) {
      throw new NoSuchFileException(path);
    }

    new RemoteFilePath(file: parts[0], pathAlias: parts[1])
  }

  String toRemotePath() {
    return "${file}@${pathAlias}"
  }

  static boolean isRemotePath(String path) {
    def parts = path.split("@")
    return parts.length == 2
  }
}
