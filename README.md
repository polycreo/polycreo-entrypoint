# ws2ten1-template-java

## prepare

* your project (ex. `ws2ten1-template-java`)
* your package (ex. `foo.bar.baz`)

## setup

1. create GitHub repository
2. create Bintray repository
3. clone this repository
4. install ws2ten1/ws2ten1-lint-for-java
5. replace string

    ```
    $ find . -type f -not -path '*/\.*' | xargs sed -i'' \
            -e 's/@@your-project@@/ws2ten1-template-java/g' \
            -e 's/@@your-package@@/foo.bar.baz/g'
    ```

6. install gradle wrapper
7. rewrite `./README.md`
8. commit and push
9. configure CircleCI
