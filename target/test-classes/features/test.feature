@lionParcel @cekTarif
Feature: Cek Tarif - Lion Parcel

  Scenario: Verify The User Open Cek Tarif Page
    Given The user opens the Lion Parcel apps
    When On beranda page, The user click Cek Tarif menu
    Then The user verify already on Cek Tarif page

  Scenario: Verify Value Asal in Cek Tarif auto filled and correct
    Given The user opens the Lion Parcel apps
    When On beranda page, The user click Cek Tarif menu
    And The user verify already on Cek Tarif page
    Then The user verify value Asal auto filled "Leces, Probolinggo (PBL)"

  Scenario: Verify Value Asal in Cek Tarif auto filled and correct
    Given The user opens the Lion Parcel apps
    When On beranda page, The user click Cek Tarif menu
    And The user verify already on Cek Tarif page

  Scenario: Verify Search Kecamatan in Tujuan
    Given The user opens the Lion Parcel apps
    When On beranda page, The user click Cek Tarif menu
    And The user verify already on Cek Tarif page
    And On cek tarif page, The user click Tujuan field
    And The user input "Mampang Prapatan" in search section
    Then The user verify result search is "Mampang Prapatan"

  Scenario: Verify Cek Tarif to Mampang Prapatan
    Given The user opens the Lion Parcel apps
    When On beranda page, The user click Cek Tarif menu
    And The user verify already on Cek Tarif page
    And On cek tarif page, The user click Tujuan field
    And The user input "Mampang Prapatan" in search section
    And The user verify result search is "Mampang Prapatan"
    And The user click result search section
    And On cek tarif page, The user click Cek Tarif button
    Then The user verify Total Biaya is correct with packet Regpack

  Scenario: Verify Cek Tarif to Mampang Prapatan with Custom Berat Barang
    Given The user opens the Lion Parcel apps
    When On beranda page, The user click Cek Tarif menu
    And The user verify already on Cek Tarif page
    And On cek tarif page, The user click Tujuan field
    And The user input "Mampang Prapatan" in search section
    And The user verify result search is "Mampang Prapatan"
    And The user click result search section
    And On cek tarif page, The user click Cek Tarif button
    And On cek tarif page, The user change total berat barang to "10" kg
    Then The user verify Total Biaya is correct with packet Regpack after update berat barang
