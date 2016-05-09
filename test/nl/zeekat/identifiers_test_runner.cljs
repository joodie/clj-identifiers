(ns nl.zeekat.identifiers-test-runner
  (:require [nl.zeekat.identifiers-test :as identifiers-test]
            [doo.runner :refer-macros [doo-all-tests]]))

(doo-all-tests #"nl\.zeekat\.identifiers.*test")



