import { useIsFocused, useNavigation } from '@react-navigation/native';
import React, { useEffect, useState } from 'react';
import { StyleSheet, ScrollView, Alert, Text, View } from 'react-native';

import Header from '../Header';

import { Order } from '../types';

export default function Orders() {
  


  const handleOnPress = (order: Order) => {
    navigation.navigate("OrderDetails", {
      order
    })
  }

  return (
    <>
      <Header />
    </>
  )

}

const styles = StyleSheet.create({
  container: {
    paddingRight: '5%',
    paddingLeft: '5%'
  }
});
