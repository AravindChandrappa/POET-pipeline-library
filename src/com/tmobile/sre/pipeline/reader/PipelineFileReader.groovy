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
package com.tmobile.sre.pipeline.reader

/**
 * Returns a file contents as a String.
 *
 * Used for stubbing out the jenkins file reading mechanism, and for
 * loading remote templates.
 */
interface PipelineFileReader extends Serializable {
    /**
     * Read file at path.
     *
     * @param path path to file
     * @return contents of file at path
     *
     * @throws java.nio.file.NoSuchFileException when file is not found
     */
    PipelineFile read(String path)
}
