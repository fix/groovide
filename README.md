# Introduction

Groovide is a tiny web editor that leverage groovlet, grape, ace, pegdown and twitter bootstrap.
It is written 100% in groovy and contains less than 500 lines!

It features:

* a file explorer, with color syntax, html and markdown preview
* mobile version (for instance browse to groovide/m/view?name=/home/)
* a file upload capability
* a file editor (using ace)
* a shell (yeah, check the source for the ajax magic!)
* a basic grails IDE (i.e. tree viewer, shell, editor, remember the last edited files when not saved, even when you closed the browser, you need HTML5 browser) at `http://host:9090/groovide/grails/ide?name=/path/to/your/grails/root/project`
* you can even stream your video from the app!

# Installation
After you forked the repository, go to the root folder and 
`groovy groovy-app.groovy`

Fire your favorite browser at [http://localhost:9090/groovide/explore/view?name=/home/](http://localhost:9090/groovide/explore/view?name=/home/).

You will be prompted for a user and a password. It is admin/groovide and it is not changeable yet, unless you change it in the source of auth/login.

Enjoy!

# Screenshots
![explorer](https://github.com/fix/groovide/raw/master/images/groovide_explore.jpg)

![markdown](https://github.com/fix/groovide/raw/master/images/groovide_md.jpg)

![shell](https://github.com/fix/groovide/raw/master/images/groovide_shell.jpg)

![editor](https://github.com/fix/groovide/raw/master/images/groovide_editor.jpg)
