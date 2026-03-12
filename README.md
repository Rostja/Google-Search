# Google-Search
HTML site with searching ability on Google

1. Creating project in InteliJ with basic files and connecting with GitHub.
2. Adding Jsoup into pom.xml, which will do parsing through various googleweb sites and collecting informations from them.
3. We created model class SearchKey which will collect results of searching.
4. Creating SearchService which is responsible for downloading and parsing Google HTML and then saving info into objects and  returning list of SearchKey.
5. Adding SearchController which get task to find some query GET/search?q=???, controller calls service, service find results, save them into objects and send them back to controller and conroller will return data in JSON (because it is REST API Contoller).
