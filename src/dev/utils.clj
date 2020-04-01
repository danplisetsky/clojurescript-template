(ns utils
  (:require [shadow.cljs.devtools.api :as shadow]))

(defn watch-and-jack-in-app []
  (shadow/watch :app)
  (shadow/repl :app))
