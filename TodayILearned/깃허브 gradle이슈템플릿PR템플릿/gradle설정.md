~~~yaml
# This workflow uses actions that are not certified by GitHub.
# They are provided by a third-party and are governed by
# separate terms of service, privacy policy, and support
# documentation.
# This workflow will build a Java project with Gradle and cache/restore any dependencies to improve the workflow execution time
# For more information see: https://docs.github.com/en/actions/automating-builds-and-tests/building-and-testing-java-with-gradle

name: Java CI with Gradle

on:
  pull_request:
    branches: [ "master" ]

permissions:
  contents: read

jobs:
  build:

    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v3
    - name: Set up JDK 11
      uses: actions/setup-java@v3
      with:
        java-version: '11'
        distribution: 'temurin'
    - name: Add permission
      run: chmod +x gradlew
    - name: Test with Gradle
      run: ./gradlew --info test
    - name: Build with Gradle
      uses: gradle/gradle-build-action@67421db6bd0bf253fb4bd25b31ebb98943c375e1
      with:
        arguments: build
~~~



~~~yaml
# This workflow uses actions that are not certified by GitHub.
# They are provided by a third-party and are governed by
# separate terms of service, privacy policy, and support
# documentation.
# This workflow will build a Java project with Gradle and cache/restore any dependencies to improve the workflow execution time
# For more information see: https://docs.github.com/en/actions/automating-builds-and-tests/building-and-testing-java-with-gradle

name: Java CI with Gradle

on:
  pull_request:
    branches: [ "dev" ]

permissions: write-all

jobs:
  build:

    runs-on: ubuntu-latest

    steps:
      - uses: actions/checkout@v3
      - name: Set up JDK 11
        uses: actions/setup-java@v3
        with:
          java-version: '11'
          distribution: 'temurin'

      - name: Setup MySQL
        uses: samin/mysql-action@v1
        with:
          character set server: 'utf8'
          mysql database: 'runninghi'
          mysql user: ${{ secrets.MYSQL_USERNAME }}
          mysql password: ${{ secrets.MYSQL_PASSWORD }}
      
      - name: make application.yml
        run:
          touch ./src/main/resources/application.yml
        shell: bash
        
      - name: deliver application.yml
        run: echo "${{ secrets.APPLICATION }}" > ./src/main/resources/application.yml
        shell: bash
        
      - name: make bootstrap.yml
        run:
          touch ./src/main/resources/bootstrap.yml
        shell: bash

      - name: deliver bootstrap
        run: echo "${{ secrets.BOOTSTRAP_SECRET }}" > ./src/main/resources/bootstrap.yml
        shell: bash

      - name: make jwt.yml
        run:
          touch ./src/main/resources/jwt.yml
        shell: bash

      - name: deliver jwt.yml
        run: echo "${{ secrets.JWT }}" > ./src/main/resources/jwt.yml
        shell: bash

      - name: Add permission
        run: chmod +x gradlew

      - name: Test with Gradle
        run: ./gradlew --info test

      - name: Build with Gradle
        uses: gradle/gradle-build-action@67421db6bd0bf253fb4bd25b31ebb98943c375e1
        with:
          arguments: build

      - name: Publish Unit Test Results
        uses: EnricoMi/publish-unit-test-result-action@v2
        if: always()
        with:
          junit_files: build/test-results/test/**/*.xml
~~~
