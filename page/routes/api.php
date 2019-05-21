<?php

use GuzzleHttp\Client;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::get('/latest_wiki_entries', function () {
    $client = new \GuzzleHttp\Client();
    $request = $client->get('https://apirest-dot-esysapp-209521.appspot.com/api/wiki_entries_100');
    $response = $request->getBody();

    return $response;
});

Route::get('/all_wiki_entries', function () {
    $client = new \GuzzleHttp\Client();
    $request = $client->get('https://apirest-dot-esysapp-209521.appspot.com/api/wiki_entries');
    $response = $request->getBody();

    return $response;
});
