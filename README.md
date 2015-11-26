# vaadin-java
demo project for spring boot




Usage
-----

Checking the starter out into directory ``app`` and get rid of the origin.

.. code:: sh

   git clone https://github.com/NickTseng/vaadin-java.git app
   cd app
   # git remote rm origin # get rid of the origin so you can add your own
   # git reset $(git commit-tree HEAD^{tree} -m "bootstrap") # squash all commits into one
   ./gradlew bootRun
   # check http://localhost:8080
