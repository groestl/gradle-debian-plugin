package de.gesellix.gradle.debian.tasks.data

import org.gradle.api.tasks.Nested
import org.gradle.util.ConfigureUtil

class Data {

  @Nested
  DataDirectory[] directories = [] as DataDirectory[]
  @Nested
  DataFile[] files = [] as DataFile[]

  def dir(Closure closure) {
    def directory = new DataDirectory()
    ConfigureUtil.configure(closure, directory)
    directories = directories.toList() + directory
  }

  def file(Closure closure) {
    def file = new DataFile()
    ConfigureUtil.configure(closure, file)
    files = files.toList() + file
  }
}
