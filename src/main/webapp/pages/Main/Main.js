/*
 * Use Injector.get for Dependency Injection
 * eg: var $timeout = Injector.get('$timeout');
 */

/* perform any action on widgets/variables within this block */
Page.onReady = function() {
    /*
     * variables can be accessed through 'Page.Variables' property here
     * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
     * Page.Variables.loggedInUser.getData()
     *
     * widgets can be accessed through 'Page.Widgets' property here
     * e.g. to get value of text widget named 'username' use following script
     * 'Page.Widgets.username.datavalue'
     */
};

Page.ProductsTable1Beforefilter = function($event, $data) {
    debugger
};
Page.ProductsTable1Beforeexport = function($data) {
    debugger
};