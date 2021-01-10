import { useIsFocused, useNavigation } from '@react-navigation/native';
import React, { useEffect, useState } from 'react';
import { StyleSheet, ScrollView, Alert, Text, View } from 'react-native';
import { TouchableWithoutFeedback } from 'react-native-gesture-handler';
import { fetchOrders } from '../api';
import Header from '../Header';
import OrderCard from '../OrderCard';
import { Order } from '../types';

export default function Orders() {
  const [orders, setOrders] = useState<Order[]>([])
  const [isLoading, setIsLoading] = useState(false)
  const navigation = useNavigation()
  const isFocused = useIsFocused()

  const fetchData = () => {
    setIsLoading(true)
    fetchOrders()
      .then(response => setOrders(response.data))
      .catch(() => Alert.alert('Houve um erro ao buscar os pedidos!'))
      .finally(() => setIsLoading(false))
  }


  const handleOnPress = (order: Order) => {
    navigation.navigate("OrderDetails", {
      order
    })
  }

  return (
    <>
      <Header />
      <ScrollView style={styles.container}>

      </ScrollView>
    </>
  )

}

const styles = StyleSheet.create({
  container: {
    paddingRight: '5%',
    paddingLeft: '5%'
  }
});
