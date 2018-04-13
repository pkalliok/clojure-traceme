(ns clojure-traceme.core
  (:require [clojure.java.io :refer [as-file]]
            [clojure.tools.namespace.find :refer [find-namespaces]]
            [clojure.tools.trace :refer [trace-ns]]))

(defn trace-project-namespaces
  "Start tracing all namespaces in this project (that is, that don't come from dependencies)."
  []
  (doseq [the-ns (find-namespaces [(as-file "src/")])]
    (trace-ns the-ns)))

