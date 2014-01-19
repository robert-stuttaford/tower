(defproject com.taoensso/tower "2.1.0-SNAPSHOT"
  :description "Clojure i18n & L10n library"
  :url "https://github.com/ptaoussanis/tower"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure     "1.4.0"]
                 [org.clojure/tools.macro "0.1.5"]
                 [markdown-clj            "0.9.35"]
                 [com.taoensso/timbre     "2.7.1"]]
  :profiles {:1.4  {:dependencies [[org.clojure/clojure "1.4.0"]]}
             :1.5  {:dependencies [[org.clojure/clojure "1.5.1"]]}
             :1.6  {:dependencies [[org.clojure/clojure "1.6.0-alpha2"]]}
             :dev  {:dependencies [[org.clojure/clojurescript "0.0-2080"]]
                    :cljsbuild {:builds
                                {:dev {:source-paths ["src/cljs"]
                                       :compiler {}}}}}
             :test {:dependencies [[expectations   "1.4.56"]
                                   [ring/ring-core "1.2.1"]]}}
  :aliases {"test-all"    ["with-profile" "+test,+1.4:+test,+1.5:+test,+1.6" "expectations"]
            "test-auto"   ["with-profile" "+test" "autoexpect"]
            "start-dev"   ["with-profile" "+dev,+test,+bench" "repl" ":headless"]
            "codox"       ["with-profile" "+test" "doc"]}
  :plugins [[lein-cljsbuild    "1.0.0"]
            [lein-expectations "0.0.8"]
            [lein-autoexpect   "1.0"]
            [lein-ancient      "0.5.4"]
            [codox             "0.6.6"]]
  :min-lein-version "2.0.0"
  :global-vars {*warn-on-reflection* true}
  :source-paths ["src/clj" "src/cljs"]
  :repositories
  {"sonatype"
   {:url "http://oss.sonatype.org/content/repositories/releases"
    :snapshots false
    :releases {:checksum :fail}}
   "sonatype-snapshots"
   {:url "http://oss.sonatype.org/content/repositories/snapshots"
    :snapshots true
    :releases {:checksum :fail :update :always}}})
