import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet';

function OrderLocation() {

  return (
    <div className="order-location-container">
        <div className="order-location-content">
        <h3 className="order-location-content">
            Selecione onde o pedido deve ser entregue
        </h3>
        <div className="filter-container">

        </div>
        </div>
    </div>
  )
}

export default OrderLocation
