package com.example.topwise;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;

import com.topwise.cloudpos.aidl.iccard.AidlICCard;

/**
 *  Chip card test
 * 
 * @author Administrator
 * 
 */
public class ICCardActivity extends BaseUtils{

	private AidlICCard iccard = null;
	String data = "";
	private static final String icCard= "icCard";



	public ICCardActivity(AidlICCard aidlICCard) {
		this.iccard = aidlICCard;
	}

	public interface ICCardCallback {
		void onEventFinish(String value);
	}

	/**
	 * open ic card
	 */
	public void open(ICCardCallback callback) {
		if(isNormalVelocityClick(DELAY_TIME)) {
			try {
				boolean flag = iccard.open();
				if (flag) {
					data = "IC Card Open Success";
					new Handler(Looper.getMainLooper()).post(new Runnable() {
						@Override
						public void run() {
							if (callback != null) {
								callback.onEventFinish(data);
							}
						}
					});
				} else {
					data = "IC Card Open Failure";
					new Handler(Looper.getMainLooper()).post(new Runnable() {
						@Override
						public void run() {
							if (callback != null) {
								callback.onEventFinish(data);
							}
						}
					});
				}
			} catch (RemoteException e) {
				e.printStackTrace();
				data = e.toString();
				new Handler(Looper.getMainLooper()).post(new Runnable() {
					@Override
					public void run() {
						if (callback != null) {
							callback.onEventFinish(data);
						}
					}
				});
			}
		} else {
			data = "Do Not Click Quickly !";
			new Handler(Looper.getMainLooper()).post(new Runnable() {
				@Override
				public void run() {
					if (callback != null) {
						callback.onEventFinish(data);
					}
				}
			});
		}
	}

	/**
	 * close ic card
	 */
	public void close(ICCardCallback callback) {
		if(isNormalVelocityClick(DELAY_TIME)) {
			try {
				boolean flag = iccard.close();
				if (flag) {
					data = "IC Card Close Success";
					new Handler(Looper.getMainLooper()).post(new Runnable() {
						@Override
						public void run() {
							if (callback != null) {
								callback.onEventFinish(data);
							}
						}
					});
				} else {
					data = "IC Card Close Failure";
					new Handler(Looper.getMainLooper()).post(new Runnable() {
						@Override
						public void run() {
							if (callback != null) {
								callback.onEventFinish(data);
							}
						}
					});
				}
			} catch (RemoteException e) {
				e.printStackTrace();
				data = e.toString();
				new Handler(Looper.getMainLooper()).post(new Runnable() {
					@Override
					public void run() {
						if (callback != null) {
							callback.onEventFinish(data);
						}
					}
				});
			}
		} else {
			data = "Do Not Click Quickly !";
			new Handler(Looper.getMainLooper()).post(new Runnable() {
				@Override
				public void run() {
					if (callback != null) {
						callback.onEventFinish(data);
					}
				}
			});
		}
	}

	public void halt(ICCardCallback callback) {
		if(isNormalVelocityClick(DELAY_TIME)) {
			try {
				int ret = iccard.halt();
				if (ret == 0x00) {

					data = "IC Card Disconnect Success";
					new Handler(Looper.getMainLooper()).post(new Runnable() {
						@Override
						public void run() {
							if (callback != null) {
								callback.onEventFinish(data);
							}
						}
					});
				} else {

					data = "IC Card Disconnect Failure";
					new Handler(Looper.getMainLooper()).post(new Runnable() {
						@Override
						public void run() {
							if (callback != null) {
								callback.onEventFinish(data);
							}
						}
					});
				}
			} catch (RemoteException e) {
				e.printStackTrace();
				data = e.toString();
				new Handler(Looper.getMainLooper()).post(new Runnable() {
					@Override
					public void run() {
						if (callback != null) {
							callback.onEventFinish(data);
						}
					}
				});
			}
		} else {
			data = "Do Not Click Quickly !";
			new Handler(Looper.getMainLooper()).post(new Runnable() {
				@Override
				public void run() {
					if (callback != null) {
						callback.onEventFinish(data);
					}
				}
			});
		}
	}


	public void apduComm(ICCardCallback callback) {
		if(isNormalVelocityClick(DELAY_TIME)) {
			byte[] apdu = HexUtil
					.hexStringToByte("0000000000");
			try {
				byte[] dataInternal = iccard.apduComm(apdu);
				if (null != dataInternal) {

					data = "Choice Main Menu Result"+ HexUtil.bcd2str(dataInternal);
					new Handler(Looper.getMainLooper()).post(new Runnable() {
						@Override
						public void run() {
							if (callback != null) {
								callback.onEventFinish(data);
							}
						}
					});

				} else {

					data = "Test APDU data failed";
					new Handler(Looper.getMainLooper()).post(new Runnable() {
						@Override
						public void run() {
							if (callback != null) {
								callback.onEventFinish(data);
							}
						}
					});
				}
			} catch (RemoteException e) {
				e.printStackTrace();
				data = e.toString();
				new Handler(Looper.getMainLooper()).post(new Runnable() {
					@Override
					public void run() {
						if (callback != null) {
							callback.onEventFinish(data);
						}
					}
				});
			}
		} else {
			data = "Do Not Click Quickly !";
			new Handler(Looper.getMainLooper()).post(new Runnable() {
				@Override
				public void run() {
					if (callback != null) {
						callback.onEventFinish(data);
					}
				}
			});
		}
	}

	public void cardReset(ICCardCallback callback) {
		if(isNormalVelocityClick(DELAY_TIME)) {
			try {
				byte[] dataInternal = iccard.reset(0x00);
				if (null != dataInternal && dataInternal.length != 0) {

					data = "IC Card Reset "+HexUtil.bcd2str(dataInternal);
					new Handler(Looper.getMainLooper()).post(new Runnable() {
						@Override
						public void run() {
							if (callback != null) {
								callback.onEventFinish(data);
							}
						}
					});
				} else {
					data = "IC Card Reset Failure";
					new Handler(Looper.getMainLooper()).post(new Runnable() {
						@Override
						public void run() {
							if (callback != null) {
								callback.onEventFinish(data);
							}
						}
					});
				}
			} catch (RemoteException e) {
				e.printStackTrace();
				data = e.toString();
				new Handler(Looper.getMainLooper()).post(new Runnable() {
					@Override
					public void run() {
						if (callback != null) {
							callback.onEventFinish(data);
						}
					}
				});
			}
		} else {
			data = "Do Not Click Quickly !";
			new Handler(Looper.getMainLooper()).post(new Runnable() {
				@Override
				public void run() {
					if (callback != null) {
						callback.onEventFinish(data);
					}
				}
			});
		}
	}

	public void isExists(ICCardCallback callback) {//检卡有事会失败，复位后再次检测
		if(isNormalVelocityClick(DELAY_TIME)) {
			try {
				boolean flag = iccard.isExist();
				if (flag) {

					data = "Card Is Exist";
					new Handler(Looper.getMainLooper()).post(new Runnable() {
						@Override
						public void run() {
							if (callback != null) {
								callback.onEventFinish(data);
							}
						}
					});

					@Override
                    public void onSuccess(TrackData trackData)
                            throws RemoteException {
                        isSwipeCard = false;

                        Map<String, String> dataMap = new HashMap<>();

                        dataMap.put("firstTrackData", trackData.getFirstTrackData());
                        dataMap.put("secondTrackData", trackData.getSecondTrackData());
                        dataMap.put("thirdTrackData", trackData.getThirdTrackData());
                        dataMap.put("cardNo", trackData.getCardno());
                        dataMap.put("expiryDate", trackData.getExpiryDate());
                        dataMap.put("formattedTrackData", trackData.getFormatTrackData());
                        dataMap.put("serviceCode", trackData.getServiceCode());

                        ObjectMapper objectMapper = new ObjectMapper();

                        try {
                            data = objectMapper.writeValueAsString(dataMap);

                            Log.d("onSuccess", "onSuccess: "+objectMapper.writeValueAsString(dataMap));

                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {
                                    if (callback != null) {
                                        callback.onEventFinish(data);
                                    }
                                }
                            });

                        } catch (JsonProcessingException e) {
                            data = e.toString();

                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {
                                    if (callback != null) {
                                        callback.onEventFinish(data);
                                    }
                                }
                            });
                        }
                    }

                    @Override
                    public void onGetTrackFail() throws RemoteException {
                        isSwipeCard = false;
                        Log.d("onGetTrackFail", "onGetTrackFail: ");

                        data = "Input Card Failed";

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                if (callback != null) {
                                    callback.onEventFinish(data);
                                }
                            }
                        });

                    }

                    @Override
                    public void onError(int arg0) throws RemoteException {
                        isSwipeCard = false;
                        Log.d("onError", "onError: ");

                        data = "Input Card Error";

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                if (callback != null) {
                                    callback.onEventFinish(data);
                                }
                            }
                        });
                    }

                    @Override
                    public void onCanceled() throws RemoteException {
                        isSwipeCard = false;
                        Log.d("onCanceled", "onCanceled: ");

                        data = "Input Card Cancelled";

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                if (callback != null) {
                                    callback.onEventFinish(data);
                                }
                            }
                        });
                    }
                });

				} else {

					data = "Card Is Not Exist";
					new Handler(Looper.getMainLooper()).post(new Runnable() {
						@Override
						public void run() {
							if (callback != null) {
								callback.onEventFinish(data);
							}
						}
					});
				}
			} catch (RemoteException e) {
				e.printStackTrace();
				data = e.toString();
				new Handler(Looper.getMainLooper()).post(new Runnable() {
					@Override
					public void run() {
						if (callback != null) {
							callback.onEventFinish(data);
						}
					}
				});
			}
		} else {
			data = "Do Not Click Quickly !";
			new Handler(Looper.getMainLooper()).post(new Runnable() {
				@Override
				public void run() {
					if (callback != null) {
						callback.onEventFinish(data);
					}
				}
			});
		}
	}


}
