(defproject identifiers "1.2.0"
  :description "Convert java style identifier names to and from lisp style"
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :profiles {:dev {:dependencies [[org.clojure/clojurescript "1.8.51"]]}}
  :plugins [[lein-doo "0.1.6"]]
  :doo {:build "test"}
  :clean-targets ^{:protect false} ["target" "test_tmp" "out"]
  :aliases {"test-cljc" ["do" "clean," "doo" "phantom" "test" "once," "test"]}
  :cljsbuild
  {:builds [{:id "test"
             :source-paths ["src" "test"]
             :compiler {:output-to "test_tmp/testable.js"
                        :main nl.zeekat.identifiers-test-runner
                        :optimizations :advanced}}]})
