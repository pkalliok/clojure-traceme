(ns clojure-traceme.core
  (:require [clojure.java.io :refer [as-file]]
            [clojure.tools.namespace.find :refer [find-namespaces]]
            [clojure.tools.trace :refer [trace-ns]]))

(defn project-namespaces
  "Get all namespaces in the current project"
  []
  (find-namespaces [(as-file "src/")]))

(defn trace-project-namespaces
  "Start tracing all namespaces in this project (that is, that don't come from dependencies)."
  []
  (doseq [the-ns (project-namespaces)]
    (println "Tracing namespace:" the-ns)
    (require the-ns)
    (trace-ns the-ns)))

