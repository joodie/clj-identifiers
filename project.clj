(defproject identifiers "1.2.0"
  :description "Convert java style identifier names to and from lisp style"
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :profiles {:dev {:dependencies [[org.clojure/clojurescript "1.8.51"]]}}
  :plugins [[lein-doo "0.1.6"]]
  :doo {:build "test"}
  :cljsbuild
  {:builds [{:id "test"
             :source-paths ["src" "test"]
             :compiler {:output-to "resources/public/js/testable.js"
                        :main nl.zeekat.identifiers-test-runner
                        :optimizations :simple}}]})
