'use client';
import { useEffect, useState } from 'react';

interface Appointment {
  appointmentID: string;
  clientId: string;
  employeeID: string;
  date: string;
  time: string;
}

const Appointments = () => {
  const [appointments, setAppointments] = useState<Appointment[]>([]);
  const [selectedAppointment, setSelectedAppointment] = useState<Appointment | null>(null);
  const [loading, setLoading] = useState(true);
  const [confirmationMessage, setConfirmationMessage] = useState<string | null>(null);

  // Fetch appointments when the component loads
  useEffect(() => {
    const fetchAppointments = async () => {
      try {
        const response = await fetch('http://localhost:8080/ITGlow/appointment/getAll', {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json',
          },
        });

        if (!response.ok) {
          throw new Error('Failed to fetch appointments');
        }

        const data = await response.json();
        setAppointments(data);
        setLoading(false);
      } catch (error) {
        console.error('Error fetching appointments:', error);
        setLoading(false);
      }
    };

    fetchAppointments();
  }, []);

  // Handle appointment selection
  const handleSelectAppointment = (appointment: Appointment) => {
    setSelectedAppointment(appointment);
    setConfirmationMessage(null); // Reset confirmation message on new selection
  };

  // Confirm the selected appointment
  const handleConfirmAppointment = async () => {
    if (!selectedAppointment) return;

    try {
      const response = await fetch(`http://localhost:8080/ITGlow/appointment/confirm/${selectedAppointment.appointmentID}`, {
        method: 'POST', // Adjust method based on your backend (POST, PATCH, etc.)
        headers: {
          'Content-Type': 'application/json',
        },
      });

      if (response.ok) {
        setConfirmationMessage('Booking confirmed successfully!');
        // Delay clearing the selected appointment to show the confirmation message first
        setTimeout(() => {
          setSelectedAppointment(null);
        }, 2000); // 2 seconds delay to keep the message visible
      } else {
        throw new Error('Failed to confirm appointment');
      }
    } catch (error) {
      console.error('Error confirming appointment:', error);
    }
  };

  if (loading) {
    return <p>Loading appointments...</p>;
  }

  return (
    <div className="container mx-auto p-6">
      <h1 className="text-2xl font-bold mb-4">Get Bookings</h1>

      {/* Appointment List */}
      <table className="table-auto w-full border-collapse">
        <thead>
          <tr className="bg-gray-200">
            <th className="border px-4 py-2">Appointment ID</th>
            <th className="border px-4 py-2">Client ID</th>
            <th className="border px-4 py-2">Employee ID</th>
            <th className="border px-4 py-2">Date</th>
            <th className="border px-4 py-2">Time</th>
            <th className="border px-4 py-2">Actions</th>
          </tr>
        </thead>
        <tbody>
          {appointments.length > 0 ? (
            appointments.map((appointment) => (
              <tr key={appointment.appointmentID}>
                <td className="border px-4 py-2">{appointment.appointmentID}</td>
                <td className="border px-4 py-2">{appointment.clientId}</td>
                <td className="border px-4 py-2">{appointment.employeeID}</td>
                <td className="border px-4 py-2">{new Date(appointment.date).toLocaleDateString()}</td>
                <td className="border px-4 py-2">{appointment.time}</td>
                <td className="border px-4 py-2">
                  <button
                    className="bg-blue-500 text-white px-4 py-2 rounded"
                    onClick={() => handleSelectAppointment(appointment)}
                  >
                    View & Confirm
                  </button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td className="border px-4 py-2" colSpan={6}>
                No appointments found.
              </td>
            </tr>
          )}
        </tbody>
      </table>

      {/* Selected Appointment Form */}
      {selectedAppointment && (
        <div className="mt-6 border p-4 rounded bg-gray-100">
          <h2 className="text-xl font-semibold">Confirm Booking</h2>
          <p><strong>Appointment ID:</strong> {selectedAppointment.appointmentID}</p>
          <p><strong>Client ID:</strong> {selectedAppointment.clientId}</p>
          <p><strong>Employee ID:</strong> {selectedAppointment.employeeID}</p>
          <p><strong>Date:</strong> {new Date(selectedAppointment.date).toLocaleDateString()}</p>
          <p><strong>Time:</strong> {selectedAppointment.time}</p>

          <button
            className="bg-green-500 text-white px-4 py-2 rounded mt-4"
            onClick={handleConfirmAppointment}
          >
            Confirm Booking
          </button>
        </div>
      )}

      {/* Confirmation Message */}
      {confirmationMessage && (
        <div className="mt-4 p-4 bg-green-200 text-green-800 rounded">
          {confirmationMessage}
        </div>
      )}
    </div>
  );
};

export default Appointments;
